package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.GestionaireDTO;
import com.GestionDeStock.stock.Entity.Admin;
import com.GestionDeStock.stock.Entity.Gestionaire;
import com.GestionDeStock.stock.Entity.Role;
import com.GestionDeStock.stock.Entity.User;
import com.GestionDeStock.stock.OpenFeign.StockLogin;
import com.GestionDeStock.stock.Repository.AdminRepository;
import com.GestionDeStock.stock.Repository.GestionaireRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GestionaireServiceImpl implements  GestionaireService{
    private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    @Autowired  private FileLoaderService fileLoaderService;

   // @Autowired
   // private PasswordEncoder passwordEncoder;

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private GestionaireRepository gestionaireRepository;

  //  @Autowired
  //  private UserRepository userRepository;

    @Autowired
    private StockLogin stockLogin;

    @Autowired
    private  MailService mailService ;

    @Override
    public GestionaireDTO registerGestionaire(String DTO , int idadmin, MultipartFile photo) throws IOException {

        Admin admin = adminRepository.findById(idadmin).orElseThrow();


        Gestionaire gestionaire = objectMapper.readValue(DTO, Gestionaire.class);

        gestionaire.setPhoto(fileLoaderService.loadFile(photo));
        gestionaire.setAdmin(admin);

         Gestionaire gestionaire1 =gestionaireRepository.save(gestionaire);

        GestionaireDTO gestionaireDTO = modelMapper.map(gestionaire1,GestionaireDTO.class);



        //User user = modelMapper.map(gestionaire,User.class);
       // user.setRole(Role.USER);

      //  user.setPassword(passwordEncoder.encode(gestionaire.getEmailVerificationKey()));

       // userRepository.save(user);

        return gestionaireDTO;
    }
    @Transactional
    @Override
    public GestionaireDTO validegestionaire(int idg, Gestionaire gestionaire) throws MessagingException, jakarta.mail.MessagingException, IOException {
        Gestionaire gestionaire1 = gestionaireRepository.findById(idg).orElseThrow();
        gestionaire1.setValide(gestionaire.isValide());
        if(gestionaire1.isValide() ){

            User user = new User();
            user.setName(gestionaire1.getName());
            user.setEmail(gestionaire1.getEmail());
            user.setRole(Role.USER);
            user.setPassword(gestionaire1.getEmailVerificationKey());
           // user.setPassword(passwordEncoder.encode(gestionaire1.getEmailVerificationKey()));


            String subject = "Account details for " + gestionaire1.getEmail();
            String content = "Dear " + gestionaire1.getName() + ",<br><br>" +
                    "Thank you for registering with our system. Your account details are:<br><br>" +
                    "Email: " + gestionaire1.getEmail() + "<br>" +
                    "Password: " + gestionaire1.getEmailVerificationKey() + "<br><br>" +
                    "Please keep your password safe and secure.<br><br>" +
                    "Regards,<br>" +
                    "Your System";
            mailService.sendEmail(gestionaire1.getEmail(), subject, content);

           gestionaireRepository.save(gestionaire1);

            stockLogin.createUser(user);

        }else {
            stockLogin.deleteUserByEmail(gestionaire1.getEmail());
        }
        GestionaireDTO gestionaireDTO = modelMapper.map(gestionaire1 , GestionaireDTO.class);
        return gestionaireDTO;
    }


    @Override
    public List<GestionaireDTO> getGestionairesByAdminId(Integer adminId) {
        List<Gestionaire> gestionaires = gestionaireRepository.findAllByAdminId(adminId);
        return gestionaires.stream()
                .map(g -> modelMapper.map(g, GestionaireDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public GestionaireDTO getgestionairebyemail(String email) {
        Gestionaire gestionaire = gestionaireRepository.getGestionaireByEmail(email);
        GestionaireDTO gestionaireDTO = modelMapper.map(gestionaire , GestionaireDTO.class);
        return gestionaireDTO;
    }

    @Override
    public void deletegestionairebyid(int idgestionaire) {
        Gestionaire gestionaire = gestionaireRepository.findById(idgestionaire).orElse(null);
        stockLogin.deleteUserByEmail(gestionaire.getEmail());
         gestionaireRepository.deleteById(idgestionaire);
    }


}
