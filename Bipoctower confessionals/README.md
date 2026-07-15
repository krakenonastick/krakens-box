# Bipoctower Confessionals

This project is a simple Node.js upload backend and a static front-end for use with GitHub Pages.

## What it does

- `index.html`, `advice.html`, `upload-success.html`, and `upload-failure.html` are the static front-end pages.
- `server.js` is a Node/Express upload API that accepts MP4 uploads at `/upload` and saves them into `uploads/`.
- The front-end can stay hosted on GitHub Pages while the backend runs separately on Render.

## Deploying the backend to Render

1. Push this repository to GitHub if it's not already there.
2. Sign in to https://render.com.
3. Click **New** → **Web Service**.
4. Connect your GitHub repo and choose this repository.
5. Set the following:
   - **Environment**: `Node` or `Node 18`
   - **Build Command**: `npm install`
   - **Start Command**: `npm start`
6. Deploy the service.
7. After deployment, Render gives you a service URL, for example:
   `https://<your-service-name>.onrender.com`

## Connect the front-end to the backend

1. Open `index.html`.
2. Update the `uploadUrl` value in the script to your Render service URL:
   ```js
   const uploadUrl = 'https://<your-service-name>.onrender.com/upload';
   ```
3. Deploy the static files to GitHub Pages as normal.
4. The page on GitHub Pages will now send uploads to the Render backend.

## Important note about storage

Render's filesystem is not permanent in the same way as a static repo:

- uploaded files will be saved in the backend instance's `uploads/` folder
- they may be lost if the service is redeployed or the instance is restarted

For permanent storage, use an object store like AWS S3, Google Cloud Storage, or another persistent storage service.

## Running locally

Install dependencies and start the backend locally:

```bash
npm install
npm start
```

Then open `index.html` in your browser or serve the static files from `server.js`.
