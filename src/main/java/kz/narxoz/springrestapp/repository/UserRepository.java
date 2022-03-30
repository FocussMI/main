package kz.narxoz.springrestapp.repository;

import kz.narxoz.springrestapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Jpa Metods
    List<User> findByNameStartsWith(String name);
    List<User> findByEmailContainingOrderByNameDesc(String email);
    List<User> findByEmailEndsWith(String task1);
    List<User> findTop2ByNameStartsWith(String task2);
    List<User> findBySurnameContaining(String task3);
    List<User> findByOrderById();
    List<User> findTop2ByOrderById();
    List<User> findByOrderByNameDesc();
    List<User> findByEmailNotContaining(String task7);
    List<User> findDistinctTop1ByName(String task10);
    // Native Query
    @Query(value = "select * from users order by email", nativeQuery = true)
    List<User> findAllSorted();
    @Query(value = "select * from users where name = surname", nativeQuery = true)
    List<User> findAllW();
    @Query(value = "select * from users where email like '%gmail.com' or email like '%narxoz.kz' or email like '%yandex.ru'", nativeQuery = true)
    List<User> findAllQ();
    @Query(value = "select distinct on (name) * from users", nativeQuery = true)
    List<User> findAllE();
    @Query(value = "select * from users where id > :qid", nativeQuery = true)
    List<User> findByGreaterId(Long qid);

}