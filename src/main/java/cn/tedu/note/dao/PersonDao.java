package cn.tedu.note.dao;



import org.springframework.stereotype.Repository;

import cn.tedu.note.entity.Person;
@Repository
public interface PersonDao {
	int addPerson(Person person);
}
