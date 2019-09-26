package s4.spring.td2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import s4.spring.td2.models.Organization;

public interface OrgaRepository extends JpaRepository<Organization,Integer > {
	public List<Organization> findByName(String name);
	public List<Organization> findByNameOrAliases(String n,String a);
}
