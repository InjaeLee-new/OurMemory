package android.memory.json;

public class MyListJson {

	@Autowired
	OurMemoryService ourMemoryService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/myListJson")
	public void myListJson(HttpServletRequest request, HttpServletResponse response) {
		int startNum = Integer.parseInt(request.getParameter("startNum"));
		int endNum = Integer.parseInt(request.getParameter("endNum"));
		String id = request.getParameter("id");
		
		List<MemoryDTO> list = ourMemoryService.memoryBoardMyList(startNum, endNum, id);
		
		String rt = null;
		if(list != null) {
		   
		   rt = "OK";
		   JSONObject json = new JSONObject();
		   json.put("rt", rt);
		   json.put("total", list.size());
		   
		   JSONArray memoryList = new JSONArray();
		   
		   for(int i = 0 ; i < list.size() ; i++) {
			    JSONObject select = new JSONObject();
		        // 12가지 항목 중 비밀번호 빼고 모두!
			    select.put("memory_num", list.get(i).getMemory_num());
		        select.put("memory_file", list.get(i).getMemory_file());
		        select.put("memory_subject", list.get(i).getMemory_subject());
		        select.put("memory_content", list.get(i).getMemory_content());
		        select.put("memory_date", list.get(i).getMemory_date());
		        select.put("memory_rec", list.get(i).getMemory_rec());
		        select.put("memory_hit", list.get(i).getMemory_hit());
		        select.put("memory_nrec", list.get(i).getMemory_nrec());
		        select.put("memory_name", list.get(i).getMemory_name());
		        select.put("memory_id", list.get(i).getMemory_id());
		        select.put("memory_category", list.get(i).getMemory_category());
		        
		        memoryList.add(select);
		   }
		   
		   json.put("memoryList", memoryList);
		   
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}		
 }
}
