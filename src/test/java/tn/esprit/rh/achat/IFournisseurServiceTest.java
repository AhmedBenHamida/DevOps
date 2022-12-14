package tn.esprit.rh.achat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.DetailFournisseurRepository;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.SecteurActiviteRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
class IFournisseurServiceTest {
	@Mock
    FournisseurRepository fournisseurRepository;

    FournisseurServiceImpl fournisseurService;
    @Mock
    DetailFournisseurRepository detailFournisseurRepository;

    SecteurActiviteRepository secteurActiviteRepository;
    @Mock
    ProduitRepository produitRepository;

    @Before
    public void setUp() { // NOSONAR
        fournisseurRepository = mock(FournisseurRepository.class);
        detailFournisseurRepository = mock(DetailFournisseurRepository.class);
        secteurActiviteRepository = mock(SecteurActiviteRepository.class);
        produitRepository = mock(ProduitRepository.class);
        fournisseurService = new FournisseurServiceImpl();
    }

    @Test
    void retrieveAllFournisseurs() {
        //Given
        this.setUp();
        List<Fournisseur> fournisseurList = new ArrayList<>();
        Fournisseur fournisseurOne = new Fournisseur();
        fournisseurOne.setIdFournisseur(1l);
        fournisseurOne.setCode("XWRE0823");
        fournisseurOne.setLibelle("libelle");
        fournisseurOne.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        Fournisseur fournisseurTwo = new Fournisseur();
        fournisseurTwo.setIdFournisseur(2l);
        fournisseurTwo.setCode("XWRE0824");
        fournisseurTwo.setLibelle("libelleTwo");
        fournisseurTwo.setCategorieFournisseur(CategorieFournisseur.CONVENTIONNE);
        fournisseurList.add(fournisseurOne);
        fournisseurList.add(fournisseurTwo);
        when(fournisseurRepository.findAll()).thenReturn(fournisseurList);
        //When

        List<Fournisseur> list = fournisseurList;
        //Then
        assertEquals(list.size(),2);
    }

    	
}