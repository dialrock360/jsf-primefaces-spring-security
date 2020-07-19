package com.yemmback.primefaces.view;

import com.yemmback.primefaces.model.Car;
import com.yemmback.primefaces.model.User;
import com.yemmback.primefaces.model.colections.Role;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Named
@RequestScoped
public class BasicView {

    private User user;
    private Car car;

    private List<Hashtable> iroles;
    private Hashtable irole;
    private Role role;


    private static final long serialVersionUID = 1L;







    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }





    //-----------------------  TEXT EDITOR ------------------------------------------------//
    private String text;

    private String text2;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    //-----------------------  TEXT EDITOR ------------------------------------------------//


    //-----------------------  InputMask ------------------------------------------------//

            private String date;
            private String phone;
            private String phoneExt;
            private String taxId;
            private String ssn;
            private String productKey;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPhoneExt() {
                return phoneExt;
            }

            public void setPhoneExt(String phoneExt) {
                this.phoneExt = phoneExt;
            }

            public String getTaxId() {
                return taxId;
            }

            public void setTaxId(String taxId) {
                this.taxId = taxId;
            }

            public String getSsn() {
                return ssn;
            }

            public void setSsn(String ssn) {
                this.ssn = ssn;
            }

            public String getProductKey() {
                return productKey;
            }

            public void setProductKey(String productKey) {
                this.productKey = productKey;
            }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Hashtable> getIroles() {
        return iroles;
    }

    public void setIroles(List<Hashtable> iroles) {
        this.iroles = iroles;
    }

    public Hashtable getIrole() {
        return irole;
    }

    public void setIrole(Hashtable irole) {
        this.irole = irole;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private String colorInline;

    private String colorPopup;

    public String getColorInline() {
        return colorInline;
    }

    public void setColorInline(String colorInline) {
        this.colorInline = colorInline;
    }

    public String getColorPopup() {
        return colorPopup;
    }

    public void setColorPopup(String colorPopup) {
        this.colorPopup = colorPopup;
    }
    //-----------------------  InputMask ------------------------------------------------//


    public void saveuser() {

        FacesMessage msg = new FacesMessage("User Created :"+user.toString() );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

//-----------------------  SelectManyMenu ------------------------------------------------//




    //-----------------------  UPLOAD VIEW  ------------------------------------------------//
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public void upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    //-----------------------  UPLOAD VIEW  ------------------------------------------------//

    //-----------------------  photo Cam VIEW  ------------------------------------------------//


    private String filename;

    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);

        return String.valueOf(i);
    }

    public String getFilename() {
        return filename;
    }

    //-----------------------  photo Cam VIEW  ------------------------------------------------//

    //-----------------------  IMAGE VIEW  ------------------------------------------------//
    private List<String> images;



    public List<String> getImages() {
        return images;
    }
    //-----------------------  IMAGE VIEW  ------------------------------------------------//






    //-----------------------  INIT VIEW  ------------------------------------------------//
    @PostConstruct
    private void init(){
        images = new ArrayList<String>();
        for (int i = 1; i <= 8; i++) {
            images.add("img" + i + ".jpg");
        }

        iroles = Role.htlistRoles();

        // List<Car> cars = this.carservice.createCars(10);
        user = new  User();
        user.setFullname("dial rock 360");
        user.setUsername("dialrock");
        user.setEmail("dialrock360@gmail.com");
        user.setPassword("123456");
        user.setPassword("123456");
        user.setRole(Role.superadmin);

    }

}
