package com.diro.ift2255.controller;

import com.diro.ift2255.model.Course;
import com.diro.ift2255.model.TableauComparaison;

public class ComparaisonController {

    private TableauComparaison tableau;

    public ComparaisonController() {
        this.tableau = new TableauComparaison();
    }

    public void selectionnerCoursComparer(Course cours) {
        if (cours == null) return;
        tableau.ajouterCours(cours);
    }

    public void deselectionnerCoursComparer(String courseId) {
        if (courseId == null) return;

        Course[] liste = tableau.getCours();
        int taille = tableau.getTaille();

        for (int i = 0; i < taille; i++) {
            if (liste[i] != null && courseId.equals(liste[i].getId())) {
                for (int j = i; j < taille - 1; j++) {
                    liste[j] = liste[j + 1];
                }
                liste[taille - 1] = null;
                return;
            }
        }
    }

    public void comparerCours(Course[] coursSelectionnes) {
        if (coursSelectionnes == null) return;

        for (Course c : coursSelectionnes) {
            if (c != null) {
                tableau.ajouterCours(c);
            }
        }
    }

    public int calculerChargeTotale() {
        return tableau.calculChargeTotale();
    }

    public void reinitialiserSelection() {
        tableau = new TableauComparaison();
    }

    public Course[] getCoursComparés() {
        return tableau.getCours();
    }
}

