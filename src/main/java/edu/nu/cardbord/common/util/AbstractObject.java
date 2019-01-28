package edu.nu.cardbord.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


@SuppressWarnings({ "rawtypes", "unchecked" })
public class AbstractObject {

	public <T> T clone(Class<T> clazz) throws Exception {
		T target = clazz.newInstance();
		BeanCopierUtils.copyProperties(this, target);  
		return target;
	}
	
	public <T> T clone(Class<T> clazz, Integer cloneDirection) throws Exception {
		T target = clazz.newInstance();
		BeanCopierUtils.copyProperties(this, target);  
		
		Class<?> thisClazz = this.getClass(); 
		
		Field[] fields = thisClazz.getDeclaredFields();

		for(Field field : fields) {
			field.setAccessible(true); 
			
			if(field.getType() != List.class) { 
				continue;
			}
			
			List<?> list = (List<?>) field.get(this); 
			if(list == null || list.size() == 0) {
				continue;
			}
			
			Class<?> listGenericClazz = getListGenericType(field); 
	        
			Class<?> cloneTargetClazz = getCloneTargetClazz(listGenericClazz, cloneDirection); 
			List clonedList = new ArrayList();
			cloneList(list, clonedList, cloneTargetClazz, cloneDirection); 
			
			Method setFieldMethod = getSetCloneListFieldMethodName(field, clazz); 
			setFieldMethod.invoke(target, clonedList); 
			
		}
		return target;
	}
	
	private void cloneList(List sourceList, List targetList, 
			Class cloneTargetClazz, Integer cloneDirection) throws Exception {
		for(Object object : sourceList) {
			AbstractObject targetObject = (AbstractObject) object;
			AbstractObject clonedObject = (AbstractObject) targetObject.clone(
					cloneTargetClazz, cloneDirection); 
			targetList.add(clonedObject); 
		}
	}
	
	private Class<?> getListGenericType(Field field) throws Exception {
		Type genericType = field.getGenericType();  
        if(genericType instanceof ParameterizedType){     
            ParameterizedType parameterizedType = (ParameterizedType) genericType;  
            return (Class<?>)parameterizedType.getActualTypeArguments()[0];   
        }   
        return null;
	}
	
	
	private Class<?> getCloneTargetClazz(Class<?> clazz, 
			Integer cloneDirection) throws Exception {
		String cloneTargetClassName = null;
		String className = clazz.getName(); 
		if(cloneDirection.equals(CloneDirection.FORWARD)) {
			if(className.endsWith(DomainType.VO)) {  
				cloneTargetClassName = className.substring(0, className.length() - 2) + "DTO";
			} else if(className.endsWith(DomainType.DTO)) {  
				cloneTargetClassName = className.substring(0, className.length() - 3) + "DO";
 			}
		}
		if(cloneDirection.equals(CloneDirection.OPPOSITE)) {
			if(className.endsWith(DomainType.DO)) {  
				cloneTargetClassName =  className.substring(0, className.length() - 2) + "DTO";
			} else if(className.endsWith(DomainType.DTO)) {  
				cloneTargetClassName = className.substring(0, className.length() - 3) + "VO";
 			}
		}
		return Class.forName(cloneTargetClassName); 
	}
	
	private Method getSetCloneListFieldMethodName(Field field, Class<?> clazz) throws Exception {
		String name = field.getName();
		String setMethodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
		Method setFieldMethod = null;
		for(Method method : clazz.getDeclaredMethods()) {
			if(method.getName().equals(setMethodName)) {
				setFieldMethod = method;
				break;
			}
		}
		return setFieldMethod;
	}
	
}
