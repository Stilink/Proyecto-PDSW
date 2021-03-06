package PROYPDSW.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import PROYPDSW.sampleprj.dao.PerfilDAO;
import PROYPDSW.sampleprj.dao.mybatis.mappers.PerfilMapper;
import PROYPDSW.samples.entities.Perfil;

public class MyBATISPerfilDAO implements PerfilDAO{
	@Inject
	private PerfilMapper pm;
	public Perfil consultarPerfil(String email) throws PersistenceException{
		Perfil p=pm.consultarPerfil(email);
		p.setInteres(pm.consultarInteresDePerfil(email));
		p.setVoluntad(pm.consultarVoluntadDePerfil(email));
		return p;
	}

	public List<Perfil> consultarUsuarios()throws PersistenceException {
		return pm.consultarUsuarios();
	}

	public List<Perfil> consultarPerfilPorRol(String rol) throws PersistenceException{
		return pm.consultarPerfilPorRol(rol);
	}

	public List<Perfil> consultarPerfilPorArea(String area) throws PersistenceException{
		return pm.consultarPerfilPorArea(area);
	}

	@Override
	public boolean validarLogin(String email, String password) throws PersistenceException {
		return pm.validarLogin(email,password);
	}

	@Override
	public void asignarRolAPerfil(Perfil perfil, String rol) {
		pm.asignarRolAPerfil(perfil, rol);
		
	}

}
