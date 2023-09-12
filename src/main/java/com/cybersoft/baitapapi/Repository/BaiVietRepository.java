package com.cybersoft.baitapapi.Repository;

import com.cybersoft.baitapapi.Entity.BaiVietEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiVietRepository extends JpaRepository<BaiVietEntity,Integer> {

}
