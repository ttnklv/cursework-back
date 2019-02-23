package com.repository;

import com.database.VotesEntity;
import com.database.VotesUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface VotesUserRepository extends JpaRepository<VotesUserEntity, Long>{


    List<VotesUserEntity> findAllByIdUserLike(int id);

    VotesUserEntity findByIdUserAndAndIdVotes(int id_user, int id_vote);

}
//findVotesUserEntitiesByIdUserAndIdVotes
