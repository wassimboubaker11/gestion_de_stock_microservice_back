package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.GestionaireDTO;
import com.GestionDeStock.stock.Entity.Gestionaire;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;


public interface GestionaireService {

    GestionaireDTO registerGestionaire(String DTO, int idadmin , MultipartFile photo ) throws IOException;

    GestionaireDTO validegestionaire(int idg , Gestionaire gestionaire) throws MessagingException, jakarta.mail.MessagingException, IOException;

    List<GestionaireDTO> getGestionairesByAdminId(Integer adminId);

    GestionaireDTO getgestionairebyemail(String email);

    void deletegestionairebyid(int idgestionaire);



}
