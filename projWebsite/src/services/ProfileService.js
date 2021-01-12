import baseURL from "../data/base-url";
import { auth } from "../utils/auth";

const PROFILE_CONFIG_REST_API_URL = "profile";

class ProfileService {

    getMyProfile() {
        return fetch(baseURL + PROFILE_CONFIG_REST_API_URL, {
                method: 'GET',
                mode: 'cors',
                headers: {
                    'Content-Type': 'application/json',
                    authorization: auth.token(),
                }
            })
            .then(res => res.json());
    }

    updateProfile() {
        return fetch(baseURL + PROFILE_CONFIG_REST_API_URL , {
            method: 'PUT',
            mode: 'cors',
            headers: {
                'Content-Type': 'application/json',
                authorization: auth.token(),
            },
            body: JSON.stringify({})
        })
    }
}

export default new ProfileService();