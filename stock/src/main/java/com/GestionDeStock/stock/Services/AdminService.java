package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.AdminDTO;
import com.GestionDeStock.stock.Entity.Admin;
import org.springframework.web.multipart.MultipartFile;


import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


public interface AdminService {
    Admin registerPartner(String DTO, MultipartFile logo) throws IOException, MessagingException, jakarta.mail.MessagingException;

    List<AdminDTO> getAllAdmin();

    AdminDTO getadminbyid(int idadmin);

     Admin valideadmin(int idadmin , Admin adminn) throws MessagingException, jakarta.mail.MessagingException, IOException;

     void deleteadmin(int idadmin);

    Admin getadminbyemail(String email);


}
