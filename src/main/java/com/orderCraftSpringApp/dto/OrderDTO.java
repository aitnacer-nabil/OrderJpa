package com.orderCraftSpringApp.dto;



import java.util.List;

public class OrderDTO {
  //  @SerializedName("client_id")
    private Long clientId;
  //  @SerializedName("list_produits")
    private List<ProduitDTO> listProduits;


    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public List<ProduitDTO> getListProduits() {
        return listProduits;
    }

    public void setListProduits(List<ProduitDTO> listProduits) {
        this.listProduits = listProduits;
    }

    public OrderDTO(Long clientId, List<ProduitDTO> listProduits) {
        this.clientId = clientId;
        this.listProduits = listProduits;
    }


    @Override
    public String toString() {
        return "OrderDTO{" +
                "clientId='" + clientId + '\'' +
                ", listProduits=" + listProduits +
                '}';
    }



}
