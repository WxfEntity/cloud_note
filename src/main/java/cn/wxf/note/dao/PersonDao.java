package cn.wxf.note.dao;



import org.springframework.stereotype.Repository;

import cn.wxf.note.entity.Person;
@Repository
public interface PersonDao {
	int addPerson(Person person);
}
