/**
 * 
 */
package com.gfe.emo._datatables;

import java.util.List;

/**
 * @author BICUGUAL
 * Objeto para Datatable.
 */
public class DataTableResponse<T> {

	/**
	 * The draw counter that this object is a response to - from the draw parameter sent as part of the data request. Note that it is strongly recommended for security reasons that you cast this parameter to an integer, rather than simply echoing back to the client what it sent in the draw parameter, in order to prevent Cross Site Scripting (XSS) attacks.
	 */
	private Long draw;
	
	/**
	 * Total records, before filtering (i.e. the total number of records in the database)
	 */
	private Long recordsTotal;
	
	/**
	 * Total records, after filtering (i.e. the total number of records after filtering has been applied - not just the number of records being returned for this page of data).
	 */
	private Long recordsFiltered;

	/**
	 * The data to be displayed in the table. This is an array of data source objects, one for each row, which will be used by DataTables. Note that this parameter's name can be changed using the ajax option's dataSrc property.
	 */
	private List<T> data;
	
	/**
	 * Optional: If an error occurs during the running of the server-side processing script, you can inform the user of this error by passing back the error message to be displayed using this parameter. Do not include if there is no error.
	 */
	private String error="Algun problema debe de haber";
	
	public DataTableResponse() {
		super();
	}

	public DataTableResponse(Long draw, Long recordsTotal, Long recordsFiltered, List<T> data, String error) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
		this.error = error;
	}

	
	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
