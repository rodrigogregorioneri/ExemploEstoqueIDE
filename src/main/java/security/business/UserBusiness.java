package security.business;

import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;


import security.dao.*;
import security.entity.*;
import java.util.*;



/**
 * Classe que representa a camada de negócios de UserBusiness
 * 
 * @generated
 **/
@Service("UserBusiness")
public class UserBusiness {

    /**
     * Instância da classe UserDAO que faz o acesso ao banco de dados
     * 
     * @generated
     */
    @Autowired
    @Qualifier("UserDAO")
    protected UserDAO repository;

    // CRUD

    /**
     * Serviço exposto para novo registro de acordo com a entidade fornecida
     * 
     * @generated
     */
    public User post(final User entity) throws Exception {
      // begin-user-code  
      // end-user-code  
      repository.save(entity);
      // begin-user-code  
      // end-user-code  
      return entity;
    }

    /**
     * Serviço exposto para recuperar a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    public User get(java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
       User result = repository.findOne(id);
      // begin-user-code  
      // end-user-code        
      return result;
    }

    /**
     * Serviço exposto para salvar alterações de acordo com a entidade fornecida
     * 
     * @generated
     */
    public User put(final User entity) throws Exception {
      // begin-user-code  
      String formPassword = entity.getPassword();
      String hashPassword = formPassword.startsWith("$2a$10$") ? formPassword : new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder().encode(formPassword);
      entity.setPassword(hashPassword);      
      // end-user-code        
      repository.saveAndFlush(entity);
      // begin-user-code  
      // end-user-code        
      return entity;
    }

    /**
     * Serviço exposto para remover a entidade de acordo com o id fornecido
     * 
     * @generated
     */
    public void delete( java.lang.String id) throws Exception {
      // begin-user-code  
      // end-user-code        
      repository.delete(id);
      // begin-user-code  
      // end-user-code        
    }

    // CRUD
    
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<User> list ( Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<User> result = repository.list (  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<User> findByRole ( java.lang.String roleid , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<User> result = repository.findByRole ( roleid ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
  /**
   * Lista com paginação de acordo com a NamedQuery
   * 
   * @generated
   */
  public Page<User> findByLogin ( java.lang.String login , Pageable pageable ){
    // begin-user-code  
    // end-user-code        
    Page<User> result = repository.findByLogin ( login ,  pageable );
    // begin-user-code  
    // end-user-code        
    return result;
  }
    
    

  /**
   * @generated modifiable
   * OneToMany Relation
   */  
  public Page<UserRole> findUserRole(java.lang.String id,  Pageable pageable) {
      // begin-user-code
      // end-user-code  
      Page<UserRole> result = repository.findUserRole(id,  pageable );
      // begin-user-code  
      // end-user-code        
      return result;	  
  }



  /**
   * @generated modifiable
   * ManyToMany Relation
   */  
  public Page<Role> listRole(java.lang.String id,  Pageable pageable ) {
      // begin-user-code
      // end-user-code  
      Page<Role> result = repository.listRole(id,  pageable );
      // begin-user-code
      // end-user-code
      return result;        	  
  }
  
  /**
   * @generated modifiable
   * ManyToMany Relation
   */    
  public int deleteRole(java.lang.String instanceId, java.lang.String relationId) {
      // begin-user-code
      // end-user-code  
      int result = repository.deleteRole(instanceId, relationId);
      // begin-user-code
      // end-user-code  
      return result;  
  }
}
