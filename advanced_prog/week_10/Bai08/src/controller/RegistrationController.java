package controller;
import model.Student;

import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

    @FXML
    public void initialize() {
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
    }

    void showError(String message) {
        lblStatus.setTextFill(Color.web("#ba8530"));;
        lblStatus.setText("Lỗi: " + message);
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
        System.out.println("Đã đăng ký thành công Model: " + newStudent);

        lblStatus.setTextFill(Color.web("#5c7f71"));
        lblStatus.setText("Đăng ký thành công cho sinh viên: " + fullName + " (" + studentId + ")");
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
}
