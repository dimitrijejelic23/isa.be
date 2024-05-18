package rs.ac.singidunum.bg.vezbe1.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserPageModel {
    private int totalPages;
    private int totalElements;
    private List<UserModel> content;
}
