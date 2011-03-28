package br.com.heldersa.giza.controller;

import br.com.heldersa.giza.entity.Pais;
import br.com.heldersa.giza.controller.util.JsfUtil;
import br.com.heldersa.giza.controller.util.PaginationHelper;
import br.com.heldersa.giza.facade.PaisFacade;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.SelectItem;
import org.primefaces.model.LazyDataModel;

@ManagedBean(name = "paisController")
@SessionScoped
public class PaisController implements Serializable {

    private Pais current;
//    private DataModel items = null;

    private LazyDataModel<Pais> items = null;

    private List<Pais> paisList;

    @EJB
    private br.com.heldersa.giza.facade.PaisFacade ejbFacade;

    private PaginationHelper pagination;

    private int selectedItemIndex;

    public PaisController() {
    }

    public Pais getSelected() {
        if (current == null) {
            current = new Pais();
            selectedItemIndex = -1;
        }
        return current;
    }

    private PaisFacade getFacade() {
        return ejbFacade;
    }

//    public PaginationHelper getPagination() {
//        if (pagination == null) {
//            pagination = new PaginationHelper(10) {
//
//                @Override
//                public int getItemsCount() {
//                    return getFacade().count();
//                }
//
//                @Override
//                public DataModel createPageDataModel() {
//                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
//                }
//            };
//        }
//        return pagination;
//    }
    public String prepareList() {
        recreateModel();
        return "listagem";
    }

    public String prepareView() {
        current = (Pais) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Pais();
        selectedItemIndex = -1;
        return "cadastro";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PaisCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Pais) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PaisUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Pais) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PaisDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
//            items = getPagination().createPageDataModel();

            items = new LazyDataModel<Pais>() {

                @Override
                public List<Pais> load(int first, int pageSize, String sortField, boolean sortOrder, Map<String, String> filters) {
                    return getFacade().findRange(new int[]{first, first + pageSize});
                }
            };

            items.setRowCount(getFacade().count());
        }
        return items;
    }

    public String filtrar(){
        //TODO 
        paisList = getFacade().findByFiltros("A", null, null);
        return null;
    }

    public List<Pais> getPaisList() {
        if (paisList == null) {
            paisList = getFacade().findAll();
        }
        return paisList;
    }

    private void recreateModel() {
        paisList = null;
        items = null;
    }

//    public String next() {
//        getPagination().nextPage();
//        recreateModel();
//        return "List";
//    }
//
//    public String previous() {
//        getPagination().previousPage();
//        recreateModel();
//        return "List";
//    }
    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Pais.class)
    public static class PaisControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PaisController controller = (PaisController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "paisController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Pais) {
                Pais o = (Pais) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PaisController.class.getName());
            }
        }
    }
}
