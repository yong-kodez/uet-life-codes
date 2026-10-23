import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeClassifierTest {
    @Test
    void testYeu() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0));
        assertEquals("Yếu", GradeClassifier.classifyGrade(2.5));
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.99));
    }

    @Test
    void testTrungBinh() {
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.8));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.49));
    }

    @Test
    void testKha() {
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));
        assertEquals("Khá", GradeClassifier.classifyGrade(7.5));
        assertEquals("Khá", GradeClassifier.classifyGrade(7.99));
    }

    @Test
    void testGioi() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(9.0));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }
    
    @Test
    void testException() {
        assertThrows(IllegalArgumentException.class, () -> { GradeClassifier.classifyGrade(-0.1); });
        assertThrows(IllegalArgumentException.class, () -> { GradeClassifier.classifyGrade(10.1); });
    }
}
