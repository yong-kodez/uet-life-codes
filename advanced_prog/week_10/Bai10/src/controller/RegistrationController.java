package controller;
import model.Student;
import model.StudentDAO;

import java.sql.SQLException;
import java.time.LocalDate;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class RegistrationController {
    @FXML private TextField txtStudentId;
    @FXML private TextField txtFullName;
    @FXML private DatePicker dpBirthDate;
    @FXML private RadioButton rbMale;
    @FXML private RadioButton rbFemale;
    @FXML private RadioButton rbOther;
    @FXML private ComboBox<String> cbMajor;
    @FXML private TextField txtEmail;
    @FXML private Label lblStatus;    
    private ToggleGroup genderGroup;

    @FXML private Button btnSave;
    @FXML private Button btnLoad;
    @FXML private Button btnReset;
    @FXML private Button btnExit;
    @FXML private ProgressIndicator piLoading;

    void setupKeyboard() {
        txtStudentId.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) txtFullName.requestFocus();
        });
        txtFullName.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) dpBirthDate.requestFocus();
        });
        txtStudentId.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) handleRegister(null);
        });
    }
    void setupRealtimeValidation() {
        txtStudentId.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.trim().isEmpty()) {
                setFieldError(txtStudentId, "Mã sinh viên không được trống");
            } else {
                clearFieldError(txtStudentId);
            }
        });
        txtFullName.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.trim().isEmpty()) {
                setFieldError(txtFullName, "Họ tên không được trống");
            } else {
                clearFieldError(txtFullName);
            }
        }); 
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        txtEmail.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.trim().isEmpty()) {
                setFieldError(txtEmail, "Email không được trống");
            } else if (!newVal.matches(emailRegex)) {
                setFieldError(txtEmail, "Email sai định dạng (<...>@<...>.<...>)");
            } else {
                clearFieldError(txtEmail);
            }
        });
    }
    void setFieldError(TextField tf, String errorMsg) {
        tf.setStyle("-fx-border-color: #ef4444; -fx-border-width: 1.5px; -fx-border-radius: 4px;");
        showError(errorMsg);
    }
    void clearFieldError(TextField tf) {
        tf.setStyle("");
        lblStatus.setText("");
    }

    @FXML
    public void initialize() {
        StudentDAO.initDatabase();

        cbMajor.setItems(FXCollections.observableArrayList(
                "Kĩ thuật máy tính",
                "Công nghệ thông tin",
                "Trí tuệ nhân tạo",
                "Công nghệ nông nghiệp"
        ));
        genderGroup = new ToggleGroup();
        rbMale.setToggleGroup(genderGroup);
        rbFemale.setToggleGroup(genderGroup);
        rbOther.setToggleGroup(genderGroup);

        setupKeyboard();
        setupRealtimeValidation();
    }

    void showError(String message) {
        lblStatus.setTextFill(Color.web("#ba8530"));
        lblStatus.setText(message);
    }
    void showSuccess(String message) {
        lblStatus.setTextFill(Color.web("#5c7f71"));
        lblStatus.setText(message);
    }
    void setLoadingState(boolean isLoading) {
        piLoading.setVisible(isLoading);
        btnSave.setDisable(isLoading);
        btnLoad.setDisable(isLoading);
        btnReset.setDisable(isLoading);
    }
    @FXML 
    public void handleRegister(ActionEvent event) {
        String studentId = txtStudentId.getText().trim();
        String fullName = txtFullName.getText().trim();
        LocalDate birthDate = dpBirthDate.getValue();
        String major = cbMajor.getValue();
        String email = txtEmail.getText().trim();
        RadioButton selected = (RadioButton)genderGroup.getSelectedToggle();
        String gender = (selected != null) ? selected.getText() : "";

        if (studentId.isEmpty()) {
            showError("Mã sinh viên trống!");
            txtStudentId.requestFocus();
            return;
        }
        if (fullName.isEmpty()) {
            showError("Họ và tên trống!");
            txtFullName.requestFocus();
            return;
        }
        if (birthDate == null) {
            showError("Ngày sinh trống!");
            dpBirthDate.requestFocus();
            return;
        }
        if (birthDate.isAfter(LocalDate.now())) {
            showError("Ngày sinh không thể lớn hơn ngày hiện tại!");
            dpBirthDate.requestFocus();
            return;
        }
        if (major == null || major.isEmpty()) {
            showError("Ngành học trống!");
            cbMajor.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            showError("Email trống!");
            txtEmail.requestFocus();
            return;
        }

        Student newStudent = new Student(studentId, fullName, birthDate, gender, major, email);
        setLoadingState(true);
        Thread saveThread = new Thread(() -> {
            try {
                Thread.sleep(1000);

                boolean success = StudentDAO.saveStudent(newStudent);
                Platform.runLater(() -> {
                    setLoadingState(false);
                    if (success) {
                        showSuccess("Đăng ký thành công cho sinh viên: " + fullName + " (" + studentId + ")");
                    }
                    System.out.println("Đã đăng ký thành công Model: " + newStudent);
                });
            } catch (SQLException e) {
                Platform.runLater(() -> {
                    setLoadingState(false);
                    showError("Lỗi Database khi lưu (" + e.getMessage() + ")");
                });
            } catch (InterruptedException e) {
                Platform.runLater(() -> setLoadingState(false));
            }
        });
        saveThread.setDaemon(true);
        saveThread.start();
    }

    @FXML
    private void handleReset(ActionEvent event) {
        txtStudentId.clear();
        txtFullName.clear();
        dpBirthDate.setValue(null);
        cbMajor.getSelectionModel().clearSelection();
        txtEmail.clear();
        lblStatus.setText("");
    }

    @FXML
    private void handleExit(ActionEvent event) {
        Stage stage = (Stage)lblStatus.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handleLoad(ActionEvent event) {
        String studentId = txtStudentId.getText().trim();
        if (studentId.isEmpty()) {
            showError("Nhập mã sinh viên cần tải");
            txtStudentId.requestFocus();
            return;
        }

        setLoadingState(true);
        Thread loadThread = new Thread(() -> {
            try {
                Thread.sleep(800);

                Student s = StudentDAO.getStudentById(studentId);
                Platform.runLater(() -> {
                    setLoadingState(false);
                    if (s == null) {
                        showError("Không tìm thấy sinh viên: " + studentId);
                        return;
                    }
                    txtFullName.setText(s.getFullName());
                    dpBirthDate.setValue(s.getBirthDate());
                    cbMajor.setValue(s.getMajor());
                    txtEmail.setText(s.getEmail());
                    if ("Nữ".equalsIgnoreCase(s.getGender())) {
                        rbFemale.setSelected(true);
                    } else if ("Nam".equalsIgnoreCase(s.getGender())) {
                        rbMale.setSelected(true);
                    } else {
                        rbOther.setSelected(true);
                    }
                    showSuccess("Đã tải dữ liệu sinh viên: " + studentId);
                });
            } catch (SQLException e) {
                Platform.runLater(() -> {
                    setLoadingState(false);
                    showError("Lỗi Database khi truy vấn: " + e.getMessage());
                });
            } catch (InterruptedException e) {
                Platform.runLater(() -> setLoadingState(false));
            }
        });
        loadThread.setDaemon(true);
        loadThread.start();
    }
}
