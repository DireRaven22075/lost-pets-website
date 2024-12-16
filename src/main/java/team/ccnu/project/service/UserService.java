package team.ccnu.project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team.ccnu.project.Utils;
import team.ccnu.project.data.request.LogInDTO;
import team.ccnu.project.data.request.SignUpDTO;
import team.ccnu.project.domain.entity.User;
import team.ccnu.project.domain.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repos;
    public void update(User user) {
        repos.save(user);
    }
    public void signUp(SignUpDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        String salt = Utils.getInstance().getSalt();
        user.setHash(salt);
        user.setPw(Utils.getInstance().encodePW(dto.getPw() + salt));
        user.setName(dto.getName());
        user.setEmail(dto.getMail());
        user.setRole('U');
        repos.save(user);
        return;
    }
    public boolean equalsPW(LogInDTO dto) {
        User user = repos.findById(dto.getId());
        return user.getPw().equals(Utils.getInstance().encodePW(dto.getPw() + user.getHash()));
    }
    public User login(LogInDTO dto) {
        return repos.findById(dto.getId());
    }

    public boolean isExistID(String id) {
        return repos.findById(id) != null;
    }
    public boolean isExistEMail(String email) {
        return repos.findByEmail(email) != null;
    }

    public User findByEmail(String email) {
        return repos.findByEmail(email);
    }
    public User findById(String id) {
        return repos.findById(id);
    }
    public User findBySn(Long sn) {
        return repos.findBySn(sn);
    }
}
