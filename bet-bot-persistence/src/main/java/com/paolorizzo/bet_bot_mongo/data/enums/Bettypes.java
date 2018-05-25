package com.paolorizzo.bet_bot_mongo.data.enums;

import com.paolorizzo.bet_bot_mongo.data.model.Bettype;

public enum Bettypes {
	
	BETTYPE_1X2_1("1X2","1","bettype.1X2.1.description"),
	BETTYPE_1X2_X("1X2","X","bettype.1X2.X.description"),
	BETTYPE_1X2_2("1X2","2","bettype.1X2.2.description"),
	BETTYPE_GOALNOGOAL_GOAL("Goal_/_No_Goal","Goal","bettype.Goal_/_No_Goal.Goal.description"),
	BETTYPE_GOALNOGOAL_NOGOAL("Goal_/_No_Goal","No_Goal","bettype.Goal_/_No_Goal.N_Goal.description"),
	BETTYPE_DOPPIACHANCE_1X("Doppia_Chance","1X","bettype.Doppia_Chance.1X.description"),
	BETTYPE_DOPPIACHANCE_12("Doppia_Chance","12","bettype.Doppia_Chance.12.description"),
	BETTYPE_DOPPIACHANCE_X2("Doppia_Chance","X2","bettype.Doppia_Chance.X2.description");
	private String parent;
	private String key;
	private String description;
	
	private Bettypes(String parent,String key,String description){
		this.setParent(parent);
		this.setKey(key);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getParent() {
		return parent;
	}



	public void setParent(String parent) {
		this.parent = parent;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}
	
	public static Bettype convert(Bettypes bettypes){
		synchronized (bettypes) {
			Bettype bettype = new Bettype();
			bettype.setDescription(bettypes.description);
			bettype.setParent(bettypes.parent);
			bettype.setKey(bettypes.key);
			return bettype;	
		}
	}
	
}
