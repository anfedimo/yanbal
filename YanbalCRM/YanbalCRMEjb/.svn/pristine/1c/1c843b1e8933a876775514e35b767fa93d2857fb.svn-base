package co.sistemcobro.yanbal.constante;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum GrupoTIpificacionEnum {
	DIRECTO(1),INDIRECTO(2),NO_CONTACTO(3),CASOS_ESPECIALES(4);

	protected static final Map<Integer, GrupoTIpificacionEnum> mapByID = new HashMap<>();
	protected static final Map<String, GrupoTIpificacionEnum> mapByNAME = new HashMap<>();

	static {
		for (GrupoTIpificacionEnum s : EnumSet.allOf(GrupoTIpificacionEnum.class)) {
			mapByID.put(s.getIndex(), s);
			mapByNAME.put(s.name(), s);
		}
	}

	private int index;

	GrupoTIpificacionEnum(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public String getIndexString() {
		return String.valueOf(index);
	}

	public static GrupoTIpificacionEnum get(int id) {
		return mapByID.get(id);
	}

	public static GrupoTIpificacionEnum get(String name) {
		return mapByNAME.get(name);
	}

}
