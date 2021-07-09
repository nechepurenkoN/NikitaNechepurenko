package data;

import java.util.List;
import lombok.Value;

@Value
public class UserRow {
    String number;
    String username;
    String description;
    List<String> dropdownValues;
}
