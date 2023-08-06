import objects.User;
import org.junit.Test;
import selection.H1304Ob;

import java.util.List;

public class TestJDBC {

    @Test
    public void test_1_GetNameFamilyDateById() {
        String userId = "7"; // Вказати  реальний id користувача з бази даних
        String actualValue = H1304Ob.getNameFamilyDateById(userId);
        System.out.println("Actual value: " + actualValue); // Вивід фактичного значення "name" "family" "date"
    }
    @Test
    public void test_2_GetNamesAndFamiliesWithSameCity() {
        String cityName = "Kiev"; // Замініть на назву міста, для якого ви хочете отримати список
        List<String> actualList = H1304Ob.getNamesAndFamiliesWithSameCity(cityName);
        System.out.println("Names and families in " + cityName + ": " + actualList); // Вивід фактичного списку
    }

    @Test
    public void test_3_Date_in_DB(){
        for (User l : H1304Ob.getUserObjects("Mary")) {
            System.out.println(l.date);
        }
    }
}

