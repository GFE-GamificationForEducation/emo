package com.gfe.emo._datatables;

public class QueryUtils {


	/**
	 * PAGINACION DATATABLES
	 * 
	 * Envuelve la consulta en un rownum para establecer el numero de registros a mostrar en base a los parametros recibidos que indican cual es 
	 * el registro inicial y cual es el último 
	 * @param datatableFilters
	 * @param query
	 * @return
	 */
    public static  String createTempDatatable(DataTableRequest datatableFilters , String query)
    {
		String queryAux="";
		String order=(datatableFilters.getOrderColumn()!=null && !datatableFilters.getOrderColumn().isEmpty() && !"0".equals(datatableFilters.getOrderColumn())) ? " ORDER BY "+datatableFilters.getOrderColumn() : "";
		String orderAscDsc=!order.isEmpty() ? " "+datatableFilters.getAscDsc() : "";
		
		
		if (datatableFilters.getLength()!=null && datatableFilters.getStart()!=null){
			queryAux= "SELECT  b.* FROM (SELECT a.*  FROM (" + query + order+orderAscDsc+" )a)b"; //  where "
//					+ "rnum > " + (datatableFilters.getStart()) +" and rnum < " +(datatableFilters.getStart()+datatableFilters.getLength()+1);
			return queryAux;
		}else{
			queryAux= "SELECT  b.* FROM (SELECT a.*  FROM (" + query + order + orderAscDsc + ")a)b" ;
			return queryAux;
		}
    }
    
    public static  String getQueryLimits(DataTableRequest datatableFilters , String query)
    {
		String queryAux="";
		String order=(datatableFilters.getOrderColumn()!=null && !datatableFilters.getOrderColumn().isEmpty() && !"0".equals(datatableFilters.getOrderColumn())) ? " ORDER BY "+datatableFilters.getOrderColumn() : "";
		String orderAscDsc=!order.isEmpty() ? " "+datatableFilters.getAscDsc() : "";
		
		
		if (datatableFilters.getLength()!=null && datatableFilters.getStart()!=null){
			queryAux= "SELECT c.rowid, c.* FROM (SELECT b.rowid, b.*  FROM (" + query + order+orderAscDsc+" )b)c  where "
					+ "c.rowid > " + (datatableFilters.getStart()) +" and c.rowid < " +(datatableFilters.getStart()+datatableFilters.getLength()+1);
			return queryAux;
		}else{
			queryAux= "SELECT * FROM (SELECT a.*  FROM (" + query + order + orderAscDsc + ")a)" ;
			return queryAux;
		}
    }
    /**
	 * FILTRO DE BUSQUEDAS POR COLUMNAS. 
	 * 
	 * Contruccion de la where concatenando condiciones AND en funcion de los filtros de busqueda por
	 * columna en el datatable.
	 * Para uso con busqueda de filtro individual por columna. Ignora sensitiveCase y acentos. 
	 * @param datatableFilters
	 * @return
	 */
	public static String getWhereColumnConditionTranslateAndUpper(DataTableRequest datatableFilters){
		StringBuffer whereSearch=new StringBuffer();
		for (TableColumn dtc:datatableFilters.getLstColumns()){
			if (dtc.getSearchable() && !dtc.getSearchValue().isEmpty()){
				if (whereSearch.length()!=0)
					whereSearch.append(" AND ");
					whereSearch.append("TRANSLATE (UPPER ("+dtc.getName()+"), 'ÁÉÍÓÚ', 'AEIOU') "
					+ "LIKE TRANSLATE(UPPER ('%"+dtc.getSearchValue() + "%'), 'ÁÉÍÓÚ', 'AEIOU')");
			}
		}
		return whereSearch.toString();
	}
	/**
	 * FILTRO DE BUSQUEDA GENERAL 
	 * Contruccion de la where concatenando condiciones OR para todas las columnas configuradas como "de busqueda" 
	 * con el filtro de busqueda general.
	 * Para uso con busqueda general en todas las columnas. Ignora sensitiveCase y acentos.
	 * @param datatableFilters
	 * @return
	 */
	public static String getWhereGlobalConditionTranslateAndUpper(DataTableRequest datatableFilters){
		StringBuffer whereSearch=new StringBuffer();
		for (TableColumn dtc:datatableFilters.getLstColumns()){
			if (dtc.getSearchable()){
				if (whereSearch.length()!=0)
					whereSearch.append(" OR ");
					whereSearch.append("TRANSLATE (UPPER ("+dtc.getName()+"), 'ÁÉÍÓÚ', 'AEIOU') "
					+ "LIKE TRANSLATE(UPPER ('%"+datatableFilters.getSearchValue() + "%'), 'ÁÉÍÓÚ', 'AEIOU')");
			}
		}
		return whereSearch.toString();
	}
}
	
