package com.vmoving.dto;

import java.io.Serializable;

public class AllActTypesDto implements Serializable {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String acttype;
		private boolean ischecked;
		public String getActtype() {
			return acttype;
		}
		public void setActtype(String acttype) {
			this.acttype = acttype;
		}
		public boolean isIschecked() {
			return ischecked;
		}
		public void setIschecked(boolean ischecked) {
			this.ischecked = ischecked;
		}
}
