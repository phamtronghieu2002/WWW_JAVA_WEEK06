package fit.iuh.www_lap_week06_20062501_phamtronghieu.repositories;


import fit.iuh.www_lap_week06_20062501_phamtronghieu.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//findUserByEmailAndpAndPasswordHash
    User findUserByEmailAndPasswordHash(String email, String passwordHash);



}