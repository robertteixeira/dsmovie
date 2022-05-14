import axios from "axios";
import MovieCard from "components/MovieCard";
import Pagination from "components/pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "utils/requests";

function Listining() {

    const [pageNumber, setPageNumber] = useState(0);

    const [page, setPage] = useState<MoviePage>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 10,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    // Exceute the function (param 1) when an observed object get some action. 
    // In this case, when the pageNuber changes, the request will be done again.
    useEffect(() => {
        axios.get(`${BASE_URL}/movies?size=8&page=${pageNumber}&sort=title`)
            .then(response => {
                const data = response.data as MoviePage;
                setPage(data);
                console.log(response.data);
            });
    }, [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <>
            <Pagination page={page} onChange={handlePageChange} />

            <div className="container">
                <div className="row">
                    {page.content.map(itemMovie =>
                        <div key={itemMovie.id} className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                            <MovieCard movie={itemMovie} />
                        </div>
                    )}

                </div>
            </div>
        </>
    );
}

export default Listining;