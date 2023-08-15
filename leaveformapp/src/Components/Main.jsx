
import { Link } from "react-router-dom";
function Main() {

    return(
        <>
        <Link to ="/addemp"><button >Add Data </button></Link> 
        <Link to ="/leave"><button >Apply Leave </button></Link>  
      <Link to ="/list"><button >Leave List </button></Link>  
        </>
    )
}
export default Main;