package com.service;

import com.database.ComplaintEntity;
import com.repository.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ComplaintService {

    private final ComplaintRepository repository;

    @Autowired
    public ComplaintService(ComplaintRepository repository) {
        this.repository = repository;
    }

    public String returnAnswers() {
        try {
            StringBuilder allAnswers = new StringBuilder();
            List<ComplaintEntity> complaintEntities = repository.findComplaintEntitiesById(1);
            for (ComplaintEntity complaintEntity : complaintEntities) {
                allAnswers.append(complaintEntity.getAnswer());
                allAnswers.append("\n");
//                18:30
            }
            return allAnswers.toString();
        } catch (NullPointerException ex) {
            return null;
        }
    }


    //TODO: как-то странно заполняется
    public String returnAllComplaintForDevelopers() {
        String allComplains = "";
        try {
            List<ComplaintEntity> complaintEntities = repository.findComplaintEntitiesByIdNotNull();
            for (ComplaintEntity complaintEntity : complaintEntities) {
                allComplains = allComplains + " Пользователь: ";
//            allComplains = allComplains + complaintEntity.getIdCustomers();
                allComplains = allComplains + " Сообщение: ";
                allComplains = allComplains + complaintEntity.getBody();
                allComplains = allComplains + ("\n");
            }
        } catch (NullPointerException ex) {
            return null;
        }

        return allComplains;
    }

    public String saveNewComplaint() {
        ComplaintEntity complaintEntity = new ComplaintEntity();
        complaintEntity.setBody("Мне не понравился фильм, который появился у меня в ленте, поэтому я обиделся.");
        complaintEntity.setIdCustomers(1);
        try {
            repository.save(complaintEntity);
            return "Your complaint saved";
        } catch (NullPointerException ex) {
            return null;
        }
    }

    //TODO : удалние жалобы, если она рассмотрена

    //TOdo: вывести тольок актуальные жалобы сделала флаг

//    public void deletComplaint(long id){
//
//repository.deleteById(id);
//    }
//
//    public LinkedList<ComplaintEntity> currentComplaint(){
//        //вот здесь выборка непроверенных
//        LinkedList<ComplaintEntity> list = repository.dateSelect();
//        return list;
//    }
}
