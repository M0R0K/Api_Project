package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDataModel {
    int id;
    String email;
    String first_name;
    String last_name;
    String avatar;
}
