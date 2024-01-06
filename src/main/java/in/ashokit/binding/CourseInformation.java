package in.ashokit.binding;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Course_Information")
public class CourseInformation {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer cid;
   private String cname;
   private Double cprice;
}
