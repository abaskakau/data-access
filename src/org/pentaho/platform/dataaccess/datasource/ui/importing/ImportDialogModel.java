/*
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * Copyright 2008 - 2009 Pentaho Corporation.  All rights reserved.
 *
 *
 * Created December 08, 2011
 * @author Ezequiel Cuellar
 */

package org.pentaho.platform.dataaccess.datasource.ui.importing;

import java.util.ArrayList;
import java.util.List;

import org.pentaho.platform.dataaccess.datasource.beans.Connection;
import org.pentaho.ui.xul.XulEventSourceAdapter;
import org.pentaho.ui.xul.stereotype.Bindable;

public class ImportDialogModel extends XulEventSourceAdapter {

	private List<Connection> connectionList;
	private List<ParameterDialogModel> analysisParameters;

	public ImportDialogModel() {
		connectionList = new ArrayList<Connection>();
		analysisParameters = new ArrayList<ParameterDialogModel>();
	}

	public void addParameter(String name, String value) {
		analysisParameters.add(new ParameterDialogModel(name, value));
		this.firePropertyChange("analysisParameters", null, analysisParameters);
	}

	public void removeParameter(int paramIndex) {
		analysisParameters.remove(paramIndex);
		this.firePropertyChange("analysisParameters", null, analysisParameters);
	}
	
	public void removeAllParameters() {
		analysisParameters.clear();
		this.firePropertyChange("analysisParameters", null, analysisParameters);
	}

	@Bindable
	public List<ParameterDialogModel> getAnalysisParameters() {
		return analysisParameters;
	}

	@Bindable
	public void setAnalysisParameters(List<ParameterDialogModel> value) {
		List<ParameterDialogModel> previousValue = analysisParameters;
		this.analysisParameters = value;
		this.firePropertyChange("analysisParameters", previousValue, value);
	}

	@Bindable
	public List<Connection> getConnectionList() {
		return connectionList;
	}

	@Bindable
	public void setConnectionList(List<Connection> value) {
		List<Connection> previousValue = connectionList;
		this.connectionList = value;
		this.firePropertyChange("connectionList", previousValue, value);
	}
}
