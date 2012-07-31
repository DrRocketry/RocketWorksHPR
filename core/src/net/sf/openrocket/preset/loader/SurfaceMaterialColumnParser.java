package net.sf.openrocket.preset.loader;

import net.sf.openrocket.material.Material;
import net.sf.openrocket.preset.TypedKey;
import net.sf.openrocket.preset.TypedPropertyMap;

public class SurfaceMaterialColumnParser extends BaseColumnParser {

	private final MaterialHolder materialMap;

	private final TypedKey<Material> param;
	
	public SurfaceMaterialColumnParser(MaterialHolder materialMap, String columnName, TypedKey<Material> param) {
		super(columnName);
		this.param = param;
		this.materialMap = materialMap;
	}
	

	@Override
	protected void doParse(String columnData, String[] data, TypedPropertyMap props) {

		if ( columnData == null || "".equals(columnData.trim())) {
			return;
		}
		
		Material.Surface myMaterial = (Material.Surface) Material.newUserMaterial(Material.Type.SURFACE,columnData, 0.0);
		Material.Surface m = materialMap.getSurfaceMaterial(myMaterial, null);
		props.put(param, m!=null ? m : myMaterial);

	}

}
