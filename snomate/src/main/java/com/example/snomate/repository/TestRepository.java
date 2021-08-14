package com.example.snomate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.snomate.model.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

	Test findById(int i);
	
//	사용자 지정 네이티브 쿼리
//	@Query(value = "SELECT * FROM test where~" , nativeQuery = true)
//	List<Test> findByUid();
	
//	레코드 삭제, 수정 쿼리 but 우리는 삭제 코드 사용하면 안됩니다~
//	@Modifying
//	@Transactional
//	@Query(value = "delete from test where " , nativeQuery = true)
//	int deleteLog();

}
