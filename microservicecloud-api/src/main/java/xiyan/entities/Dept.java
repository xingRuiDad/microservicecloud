package xiyan.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
@Getter
@Setter
public class Dept  implements Serializable{
	private Long deptno;
	private String dname;
	private String db_source;
}

