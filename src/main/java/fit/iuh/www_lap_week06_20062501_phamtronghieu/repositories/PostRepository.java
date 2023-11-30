package fit.iuh.www_lap_week06_20062501_phamtronghieu.repositories;


import fit.iuh.www_lap_week06_20062501_phamtronghieu.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}