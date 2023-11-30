package fit.iuh.www_lap_week06_20062501_phamtronghieu.repositories;


import fit.iuh.www_lap_week06_20062501_phamtronghieu.entities.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}