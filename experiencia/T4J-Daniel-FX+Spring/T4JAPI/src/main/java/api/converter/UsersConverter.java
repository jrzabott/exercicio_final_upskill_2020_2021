package api.converter;

import api.DTO.UsersDTO;
import api.model.Users;
import java.util.ArrayList;

public class UsersConverter {
    
    public static UsersDTO users2UsersDTO(Users users) throws NullPointerException {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setId(users.getId());
        usersDTO.setEmail(users.getEmail());
        usersDTO.setPassword(users.getPassword());
        usersDTO.setUsername(users.getUsername());
        return  usersDTO;
    }
    
    public static Users usersDTO2Users(UsersDTO usersDTO) throws NullPointerException {
        Users users = new Users();
        users.setId(usersDTO.getId());
        users.setEmail(usersDTO.getEmail());
        users.setPassword(usersDTO.getPassword());
        users.setUsername(usersDTO.getUsername());
        return  users;
    }
    
    public static ArrayList<UsersDTO> listUsers2ListUsersDTO(ArrayList<Users> users) throws NullPointerException {
        ArrayList<UsersDTO> usersDTO = new ArrayList<>();
        for (Users user : users) {
            try {
                UsersDTO udto = users2UsersDTO(user);
                usersDTO.add(udto);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return usersDTO;
    }

    public static ArrayList<Users> listUsersDTO2ListUsers(ArrayList<UsersDTO> usersDTO) throws NullPointerException {
        ArrayList<Users> users = new ArrayList<>();
        for (UsersDTO userDTO : usersDTO) {
            try {
                Users u = usersDTO2Users(userDTO);
                users.add(u);
            } catch (NullPointerException e) {
                // Does nothing
            }
        }
        return users;
    }
}
