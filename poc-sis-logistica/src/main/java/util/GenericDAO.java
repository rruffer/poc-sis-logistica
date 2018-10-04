package util;

import java.util.List;

import javax.persistence.EntityManager;

public abstract interface GenericDAO<T>
{
  public abstract EntityManager getEntityManager();
  
  public abstract T lerPorId(Object paramObject);
  
  public abstract List<T> lerTodos();
  
  public abstract T salvar(T paramT);
  
  public abstract void excluir(T paramT);
  
  public abstract void abrirTransacao();
  
  public abstract void gravarTransacao();
  
  public abstract void desfazerTransacao();
}

