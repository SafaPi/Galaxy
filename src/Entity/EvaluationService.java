/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

/**
 *
 * @author gafsi
 */
public class EvaluationService {
    private int id;
    private int rating;
    private User user;
    private Service service;

    public EvaluationService() {
    }

    public EvaluationService(int id, int note, User user, Service service) {
        this.id = id;
        this.rating = note;
        this.user = user;
        this.service = service;
    }

    public EvaluationService(int note, User user, Service service) {
        this.rating = note;
        this.user = user;
        this.service = service;
    }

    public int getId() {
        return id;
    }
    public int getRating() {
        return rating;
    }

    public void setRating(int note) {
        this.rating = note;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setProduit(Service service) {
        this.service = service;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EvaluationService other = (EvaluationService) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Evaluationprod{" + "id=" + id + ", note=" + rating + ", user=" + user + ", service=" + service + '}';
    }
    
    
    
}
