package com.GestionDeStock.stock.Services;


import com.GestionDeStock.stock.DTO.CommandeDTO;
import com.GestionDeStock.stock.Entity.OrderItem;

import java.util.List;

public interface CommandeService {

        public void saveCommandeclientwithvariant(List<OrderItem> orderItems, int clientId, String nom);


        public void saveCommandeclient(List<OrderItem> orderItems, int clientId, String nom);

        public void saveCommande( List<OrderItem> orderItems);

        public void saveCommandefournisseur(List<OrderItem> orderItems, int clientId, String nom);

        List<CommandeDTO> getAllCommandeClient();

        List<CommandeDTO> getAllCommandeFournisseur();

        void deletecommande(int idcommande);

        CommandeDTO getCommandeById(int idcommande);

        void deletecommandefournisseur(int idcommande);
}
