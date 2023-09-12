package com.cybersoft.baitapapi.Repository;

import com.cybersoft.baitapapi.Entity.TacGiaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacGiaRepository extends JpaRepository<TacGiaEntity,Integer> {

}
