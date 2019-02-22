package com.service;

import com.database.*;
import com.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.HashSet;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;
    private final ScoreFilmRepository scoreFilmRepository;
    private  final ScoreActorRepository scoreActorRepository;
private final ScoreAnalystRepository scoreAnalystRepository;
private final ScoreStudioRepository scoreStudioRepository;
    @Autowired
    public CustomersService(CustomersRepository customersRepository, ScoreFilmRepository scoreFilmRepository, ScoreActorRepository scoreActorRepository, ScoreAnalystRepository scoreAnalystRepository, ScoreStudioRepository scoreStudioRepository) {
        this.customersRepository = customersRepository;
        this.scoreFilmRepository = scoreFilmRepository;
        this.scoreActorRepository = scoreActorRepository;
        this.scoreAnalystRepository = scoreAnalystRepository;
        this.scoreStudioRepository = scoreStudioRepository;
    }


    public String updateEmail() {
        try {
            customersRepository.findCustomersEntityById(1).setEmailHash("tanya@mail.ru");
            customersRepository.updateUserSetEmailForId("tanya@mail.ru", 1);
            return "Email was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updateLevelAccess() {
        try {
            customersRepository.findCustomersEntityById(1).setLevelAccess(2);
            customersRepository.updateUserSetLevelAccessForId(2,1);
            return "Level_Access was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updatePassword() {
        try {
            customersRepository.findCustomersEntityById(1).setPassword("root");
            customersRepository.updateUserSetPasswordForId("root", 1);
            return "Password was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updateMobailNumber() {
        try {
            customersRepository.findCustomersEntityById(1).setMobNumber("89012343948");
            customersRepository.updateUserSetMobailNumberForId("89012343948", 1);
            return "Mobail_Number was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updateName() {
        try {
            customersRepository.findCustomersEntityById(1).setName("Танечка");
            customersRepository.updateUserSetMobailNumberForId("Танечка", 1);
            return "Name was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String updateImg() {
        byte[] img = {1,2,3,4,5,6};
        try {
            customersRepository.findCustomersEntityById(1).setImg(img);
            customersRepository.updateUserSetIMGForId(img,1);
            return "IMG was changed.";
        } catch (NullPointerException ex) {
            return null;
        }
    }


    public String returnEmail() {
        //do not understand how to put here id
        try {
            return customersRepository.findById(2).getEmailHash();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public String returnHashPas() {
        try {
            return customersRepository.findById(2).getPassword();
        } catch (NullPointerException ex) {
            return null;
        }
    }

    public void scoreForFilm(int idCust, int idFilm, float score){
        ScoreFilmEntity sf = new ScoreFilmEntity();
        sf.setIdFilm(idFilm);
        sf.setIdUserUs(idCust);
        sf.setScore(score);
        scoreFilmRepository.save(sf);
    }

    public void scoreForAnalyst(int idCust, int idAnalyst, float score){
        ScoreAnalystEntity sa =  new ScoreAnalystEntity();
        sa.setIdAnalyst(idAnalyst);
        sa.setIdUserUs(idCust);
        sa.setScore(score);
        scoreAnalystRepository.save(sa);
    }

    public void scoreForActor(int idCust, int idActor, float score){
        ScoreActorEntity sa = new ScoreActorEntity();
        sa.setIdActor(idActor);
        sa.setIdUserUs(idCust);
        sa.setScore(score);
        scoreActorRepository.save(sa);
    }

    public void scoreForStudio(int idCust, int idStudio, float score){
        ScoreStudioEntity ss = new ScoreStudioEntity();
        ss.setIdStudio(idStudio);
        ss.setIdUserUs(idCust);
        ss.setScore(score);
        scoreStudioRepository.save(ss);
    }

    public void insertNewCustomer(String name,String login, String
                                  pIurl, String email, String pass, String mobile, Boolean rep,
                                  Date date, int level){

        CustomersEntity newCust = new CustomersEntity();
        newCust.setName(name);
        newCust.setLogin(login);
        newCust.setProfileImageUrl(pIurl);
        newCust.setEmailHash(email);
        newCust.setPassword(pass);
        newCust.setMobNumber(mobile);
        newCust.setReputation(rep);
        newCust.setLastAccess(date);
        newCust.setLevelAccess(level);
        customersRepository.save(newCust);

    }

    public boolean aunt(String log, String pass){
        if (customersRepository.findLogPas(log, pass) == null) return false;
        return true;
    }


    public CustomersEntity findByLog(String log){
        return customersRepository.findByLogin(log);
    }

    public CustomersEntity findById(int id){return  customersRepository.findById(id);}

    public boolean auntification(String log, String pass){
        if (customersRepository.findLogPas(log, pass) == null) return false;
        return true;
    }

    //TODO: Добавить к Маше
    public void registrationWithSocialNetwork(String first_name,
                                              String last_name,
                                              String href,
                                              String mid) {
        CustomersEntity customer = new CustomersEntity();
        try {
            customer.setName(first_name + " " + last_name);
            customer.setEmailHash(href);
            customer.setLogin(mid);

            customer.setLevelAccess(1);
            //TODO: важное преобразование времени
            java.util.Date date = new java.util.Date();
            customer.setLastAccess(new Date(date.getTime()));
            customer.setPassword(mid);
            customer.setReputation(true);
            if(customersRepository.findByLog(mid) == null) customersRepository.save(customer);
            else System.out.println("отловлен повторяющийся акк");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
