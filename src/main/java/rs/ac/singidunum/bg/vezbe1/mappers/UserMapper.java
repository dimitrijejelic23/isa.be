package rs.ac.singidunum.bg.vezbe1.mappers;

import org.springframework.data.domain.Page;
import rs.ac.singidunum.bg.vezbe1.entities.User;
import rs.ac.singidunum.bg.vezbe1.models.UserModel;
import rs.ac.singidunum.bg.vezbe1.models.UserPageModel;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserModel toModel(User entity) {
        return UserModel.builder()
                .email(entity.getEmail())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName()).build();
    }

    public static List<UserModel> toModelList(List<User> entities) {
        List<UserModel> list = new ArrayList<UserModel>();

        for (var entity : entities) {
            list.add(toModel(entity));
        }

        return list;
    }

    public static UserPageModel toModelPagedList(Page<User> userPage) {
        return UserPageModel.builder()
                .content(toModelList(userPage.getContent())).totalPages(userPage.getTotalPages())
                .totalElements(userPage.getNumberOfElements())
                .build();
    }

    public static User toEntity(UserModel model) {
        User u = new User();
        u.setId(model.getId());
        u.setFirstName(model.getFirstName());
        u.setLastName(model.getLastName());
        u.setEmail(model.getEmail());
        return u;
    }
}
