package DAO;



import model.Produto;

import java.awt.HeadlessException;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;



public class DAOProduto {



    public void Armazenar(Produto prod) {

        Session sessao = DAOHibernateUtill.getsessionFactory().getCurrentSession();

        try {

            sessao.beginTransaction();

            sessao.save(prod);

            sessao.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");

            sessao.close();

        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Aconteceu um erro: " + e.getMessage() + "!");

        }

    }



    public void Alterar(Produto prod) {

        Session sessao = DAOHibernateUtill.getsessionFactory().getCurrentSession();

        try {

            sessao.beginTransaction();

            sessao.merge(prod);

            sessao.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");

            sessao.close();

        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Aconteceu um erro: " + e.getMessage() + "!");

        }

    }



    public void Excluir(Produto prod) {

        Session sessao = DAOHibernateUtill.getsessionFactory().getCurrentSession();

        try {

            sessao.beginTransaction();

            sessao.delete(prod);

            sessao.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");

            sessao.close();        

        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Aconteceu um erro: " + e.getMessage() + "!");

        }

    }



    public List<Produto> Listar() {

        Session sessao = DAOHibernateUtill.getsessionFactory().getCurrentSession();

        List<Produto> lista = null;

        try {

            sessao.beginTransaction();

            lista = sessao.createQuery("From Produto").list();

            sessao.close();

        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Aconteceu um erro: " + e.getMessage() + "!");

        }

        return lista;

    }



    public Produto Consultar(int idProduto) {

        Session sessao = DAOHibernateUtill.getsessionFactory().getCurrentSession();

        Produto prodConsultado = new Produto();

        try {

            sessao.beginTransaction();

            prodConsultado = (Produto) sessao.get(Produto.class, idProduto);

            sessao.close();

        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Aconteceu um erro: " + e.getMessage() + "!");

        }



        return prodConsultado;

    }

}