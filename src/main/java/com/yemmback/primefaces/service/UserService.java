package com.yemmback.primefaces.service;


import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

/*
    @Autowired
    private static UserRepository userRepository;
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    public static List<User> Alluser() {
        return (List<User>) userRepository.findAll();
    }

    public static Optional<User> findUser(Long userId) {
        return userRepository.findById(userId);
    }

    public static User saveUser(User user) {
        userRepository.save(user);
        return user;
    }

    public static void deleteuser(User user) {
        userRepository.delete(user);
    }

    public static void signinUser(User user) {
        userRepository.findbyUser(user);
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", email));
        }
    }

    public static void signUpUser(User user) {


         BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
         final String encryptedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

        final User createdUser = userRepository.save(user);

        final ConfirmationToken confirmationToken = new ConfirmationToken(user);

        ConfirmationTokenService.saveConfirmationToken(confirmationToken);

    }

    public static void confirmUser(ConfirmationToken confirmationToken) {

        final User user = confirmationToken.getUser();

        user.setEnabled(true);

        userRepository.save(user);

        ConfirmationTokenService.deleteConfirmationToken(confirmationToken.getId());

    }
    void  sendConfirmationMail(String userMail, String token) {

        final SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userMail);
        mailMessage.setSubject("Mail Confirmation Link!");
        mailMessage.setFrom("<MAIL>");
        mailMessage.setText(
                "Thank you for registering. Please click on the below link to activate your account." + "http://localhost:9090/sign-up/confirm?token="
                        + token);
        new EmailSenderService().sendEmail(mailMessage);
    }
*/
}
