import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listining() {

    const [pageNumber, setPageNumber] = useState(0);

    // Exceute the function (param 1) when an observed object get some action 
    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=10&page=0`)
            .then(response => {
                const data = response.data as MoviePage;
                console.log(response.data);
                setPageNumber(data.number);
            });
    }, []);

    return (
        <>
            <p>Page Number = {pageNumber}</p>
            <Pagination />
            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                </div>
            </div>
        </>
    );
}

export default Listining;