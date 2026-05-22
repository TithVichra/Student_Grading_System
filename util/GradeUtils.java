package util;

public class GradeUtils {
    public static boolean isValidScore(double score) {
        return score >= 0 && score <= 100;
    }

    public static String calculateGrade(double score) {
        if (!isValidScore(score)) {
            return "Invalid";
        }

        if (score >= 85) {
            return "A";
        } else if (score >= 75) {
            return "B";
        } else if (score >= 65) {
            return "C";
        } else if (score >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}